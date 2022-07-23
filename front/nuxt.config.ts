import { defineNuxtConfig } from 'nuxt'

// https://v3.nuxtjs.org/api/configuration/nuxt.config
const lifecycle = process.env.npm_lifecycle_event;
export default defineNuxtConfig({

    css: [
        "~/assets/sass/index.scss",
        "~/assets/sass/main.scss"
    ],

    build: {
        transpile: lifecycle === "build" ? ["element-plus"] : [],
    },
})
