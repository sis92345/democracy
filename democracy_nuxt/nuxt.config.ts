import { defineNuxtConfig } from "nuxt";
//import vue from "@vitejs/plugin-vue";
import { quasar, transformAssetUrls } from "@quasar/vite-plugin";

export default defineNuxtConfig({
    // ssr: false,
    css: [
        "~/assets/styles/quasar.sass",
        "~/assets/sass/main.scss",
        "@quasar/extras/roboto-font/roboto-font.css",
        "@quasar/extras/material-icons/material-icons.css",
    ],
    build: {
        transpile: ["quasar"],
    },
    vite: {
        plugins: [
            quasar({
                sassVariables: "assets/styles/quasar.variables.sass",
            }),
        ],
    },
});