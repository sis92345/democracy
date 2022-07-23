import { defineNuxtConfig } from 'nuxt'

// https://v3.nuxtjs.org/api/configuration/nuxt.config
const lifecycle = process.env.npm_lifecycle_event;
export default defineNuxtConfig({

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
