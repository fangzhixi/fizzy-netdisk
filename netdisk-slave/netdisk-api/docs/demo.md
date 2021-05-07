# 通用机打发票识别


## 应用场景
本接口支持对通用机打发票的发票代码、发票号码、日期、购买方识别号、销售方识别号、校验码、小写金额等关键字段的识别。


## 地址
/ticket-ocr-api/ticket/general/v1


## 请求参数
|  参数名称    |     类型       |  必填  |  描述        |  示例   |
| ------------ | -------------  | -------| ------------ |-------- |
|image_base64   | string  |   否   | 图片的 Base64 值。<br/>支持的图片格式：PNG、JPG、JPEG，暂不支持 GIF 格式。<br/>支持的图片大小：所下载图片经Base64编码后不超过 3M。图片下载时间不超过 3 秒。<br/>图片的 ImageUrl、ImageBase64 必须提供一个，如果都提供，只使用 ImageUrl。 | data:image/jpeg;base64,/9j/4AAQSkZJRg<br />ABAQAAAQABAAD/2wBDAAYEBQYF== |
|image_url   | string  |   是   | 图片的 Url 地址。<br/>支持的图片格式：PNG、JPG、JPEG，暂不支持 GIF 格式。<br/>支持的图片大小：所下载图片经 Base64 编码后不超过 3M。图片下载时间不超过 3 秒。<br/>图片存储于腾讯云的 Url 可保障更高的下载速度和稳定性，建议图片存储于腾讯云。<br/> | https://goldenxxxxx/a.jpg |

## 响应参数


| **字段**     | **类型** | **必须** | **备注**  |
| ------------ | -------- | -------- | --------- |
| invoice_general_infos |  list  |   是     | 检测到的文本信息   |
| invoice_general_infos.name | string | 是 | 识别出的字段名称（关键字） |
| invoice_general_infos.value | string   | 是 | 识别出的字段名称对应的值，也就是字段Name对应的字符串结果 |
| invoice_general_infos.rect | list | 是 | 文本行在旋转纠正之后的图像中的像素坐标 |
| invoice_general_infos.rect.x | int32    | 是       | 左上角x                                                  |
| invoice_general_infos.rect.y | int32    | 是       | 左上角y                                                  |
| invoice_general_infos.rect.width | int32    | 是       | 宽度                                                     |
| invoice_general_infos.rect.height | int32    | 是       | 高度                                                     |
| angle | string | 是 | 图片旋转角度（角度制），文本的水平方向为0°，顺时针为正，逆时针为负。 |
| request_id | string | 是 | 唯一请求 ID |


## 请求示例
```
{"image_base64":"","image_url":"https://xx/a.jpg"}
```


## 响应示例
```
{
    "code": 0,
    "message": "",
    "data": {
        "invoice_general_infos": [
            {
                "name": "发票代码",
                "value": "241001210220",
                "rect": {
                    "x": 653,
                    "y": 81,
                    "width": 166,
                    "height": 23
                }
            },
            {
                "name": "发票号码",
                "value": "05697707",
                "rect": {
                    "x": 649,
                    "y": 116,
                    "width": 110,
                    "height": 23
                }
            },
            {
                "name": "发票消费类型",
                "value": "服务",
                "rect": {
                    "x": 0,
                    "y": 0,
                    "width": 0,
                    "height": 0
                }
            },
            {
                "name": "合计金额(大写)",
                "value": "肆佰捌拾圆整",
                "rect": {
                    "x": 295,
                    "y": 443,
                    "width": 109,
                    "height": 22
                }
            },
            {
                "name": "合计金额(小写)",
                "value": "480.00",
                "rect": {
                    "x": 0,
                    "y": 0,
                    "width": 1,
                    "height": 1
                }
            },
            {
                "name": "市",
                "value": "",
                "rect": {
                    "x": 0,
                    "y": 0,
                    "width": 0,
                    "height": 0
                }
            },
            {
                "name": "日期",
                "value": "2013年01月21日",
                "rect": {
                    "x": 205,
                    "y": 141,
                    "width": 96,
                    "height": 19
                }
            },
            {
                "name": "是否有公司印章",
                "value": "1",
                "rect": {
                    "x": 0,
                    "y": 0,
                    "width": 0,
                    "height": 0
                }
            },
            {
                "name": "省",
                "value": "河南省",
                "rect": {
                    "x": 0,
                    "y": 0,
                    "width": 0,
                    "height": 0
                }
            },
            {
                "name": "种类",
                "value": "其他",
                "rect": {
                    "x": 0,
                    "y": 0,
                    "width": 0,
                    "height": 0
                }
            },
            {
                "name": "购买方名称",
                "value": "郑州亚拓信息技术有限公司",
                "rect": {
                    "x": 231,
                    "y": 207,
                    "width": 221,
                    "height": 22
                }
            },
            {
                "name": "销售方名称",
                "value": "郑州亚拓信息技术有限公司",
                "rect": {
                    "x": 231,
                    "y": 207,
                    "width": 221,
                    "height": 22
                }
            },
            {
                "name": "销售方识别号",
                "value": "410105556909375",
                "rect": {
                    "x": 708,
                    "y": 209,
                    "width": 135,
                    "height": 19
                }
            },
            {
                "name": "校验码",
                "value": "",
                "rect": {
                    "x": 0,
                    "y": 0,
                    "width": 0,
                    "height": 0
                }
            },
            {
                "name": "购买方识别号",
                "value": "",
                "rect": {
                    "x": 0,
                    "y": 0,
                    "width": 0,
                    "height": 0
                }
            },
            {
                "name": "时间",
                "value": "",
                "rect": {
                    "x": 0,
                    "y": 0,
                    "width": 0,
                    "height": 0
                }
            }
        ],
        "angle": "0.00",
        "request_id": "8dc99a0c-3315-4d7c-b2f7-fbd67fc1717e"
    }
}
```
