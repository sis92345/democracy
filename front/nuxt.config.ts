import { defineNuxtConfig } from 'nuxt'
import {getMetaSetting} from "./config/metaConfig";

// https://v3.nuxtjs.org/api/configuration/nuxt.config
const lifecycle = process.env.npm_lifecycle_event;
export default defineNuxtConfig({


    app : {
        ...getMetaSetting()
    },


    css: [
        "~/assets/sass/index.scss",
        "~/assets/sass/main.scss"
    ],
    buildModules: ['@pinia/nuxt'],
    build: {
        transpile: lifecycle === "build" ? ["element-plus"] : []
    },

    modules: ['nuxt-proxy'],

    vite: {
        server: {
            proxy: {
                '/api': {
                    target: 'http://localhost:8080',
                    changeOrigin: true,
                    secure: false,
                },
            },
        },
    },
})
