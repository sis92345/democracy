import axios from "axios";

export default defineNuxtPlugin(nuxtApp => {
    const domain = 'http://localhost:8080';

    const serverApi = axios.create();

    return {
        provide: {
            api: serverApi
        }
    }
})