FROM ccr.ccs.tencentyun.com/golden-cloud/golang-git-base:1.14-buster AS builder

ARG CGO=0
ENV CGO_ENABLED=${CGO}
ENV GOARCH=amd64
ENV GOOS=linux
ENV GO111MODULE=on

ARG env=dev
WORKDIR /build/

COPY . /build/
RUN set -ex && \
    rm -f go.mod go.sum && \
    go mod init gateway && \
    cp -f conf_${env}.yaml conf.yaml && \
    CGO_ENABLED=${CGO_ENABLED} GOARCH=${GOARCH} GOOS=${GOOS} go build -a -o gateway .

FROM ccr.ccs.tencentyun.com/golden-cloud/debian-base:buster

ARG env
WORKDIR /work

COPY --from=builder /build/gateway .
COPY --from=builder /build/conf.yaml .

VOLUME ["/work/logs"]
EXPOSE 8080 50009
ENTRYPOINT ["./gateway", "-conf=conf.yaml"]
