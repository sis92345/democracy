import { defineNuxtConfig } from 'nuxt'
import {getMetaSetting} from "./config/metaConfig";

// https://v3.nuxtjs.org/api/configuration/nuxt.config
const lifecycle = process.env.npm_lifecycle_event;
export default defineNuxtConfig({

    /**
     * ssr : Server Side Rendering을 할 지 여부
     * democray는 ssr을 사용하지 않습니다.
     * @default true
     * @see https://v3.nuxtjs.org/api/configuration/nuxt.config#ssr
     * */
    ssr : false,

    /**
     * Web Application Configuration
     *
     * App의 전체적인 정보를 설정
     *
     * @see https://v3.nuxtjs.org/api/configuration/nuxt.config#app
     * */
    app : {
        ...getMetaSetting()
    },


    /**
     * Application CSS IMPORT
     * Nuxt는 파일 확장자로 자동으로 파일 타입을 추측합니다.
     * css를 적용시키기 위해서 여기에 css를 추가하면 됩니다.
     *
     * @see https://v3.nuxtjs.org/api/configuration/nuxt.config#css
     * */
    css: [
        "~/assets/sass/index.scss",
        "~/assets/sass/main.scss"
    ],
    buildModules: ['@pinia/nuxt'],
    build: {
        transpile: lifecycle === "build" ? ["element-plus"] : []
    },

    modules: ['nuxt-proxy'],

    proxy: {
        options: {
            target: 'http://localhost:8080',
            changeOrigin: true,
            pathRewrite: {
                '^/api': '/api'
            },
            pathFilter: [
                '/api'
            ]

        }
    }
})
