/**
 * Democracy Meta 정보 세팅
 *
 * @return {nuxtMetaObject} - nuxt Meta 정보
 * */
const getMetaSetting = function() : object {

    /**
     * @typedef nuxtMetaObject
     * */
    return {
        head : {
            title : 'Democracy',
            meta : [
                { charset : "utf-8" },
                { "http-equiv" : "X-UA-Compatible", content : "IE=edge,chrome=1" },
                { "http-equiv" : "pragma", content : "no-cache" },
                { "http-equiv" : "cache-control", content : "no-cache" },
                { "http-equiv" : "expires", content : "0" },
                { name : "robots" , content : "noindex" },
                { name : "viewport", content : "initial-scale=1.0,user-scalable=no,maximum-scale=1,width=device-width" },
                {
                    hid     : "description",
                    name    : "description",
                    content : "",
                }
            ],
            link : [
                { rel : "icon", type : "image/x-icon", href : "/favicon.ico" },
            ],
        },
    }

}

export { getMetaSetting };