import * as ElementPlusIconsVue from '@element-plus/icons-vue';
import ElementPlus from 'element-plus';

// TS 
export default defineNuxtPlugin(nuxtApp => {
    // ElementPlus
    nuxtApp.vueApp.use(ElementPlus, { size: 'small', zIndex: 3000 });

    // ElementPlus Icons
    for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
        nuxtApp.vueApp.component(key, component)
    }
})