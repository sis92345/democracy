import axios, {AxiosInstance} from "axios";

export default defineNuxtPlugin(nuxtApp => {

    const serverApi : AxiosInstance = axios.create();

    return {
        provide: {
            api: serverApi
        }
    }
})
