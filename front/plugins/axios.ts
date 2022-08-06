import axios from "axios";

export default defineNuxtPlugin(nuxtApp => {
    const domain = 'http://localhost:8080';

<<<<<<< Updated upstream
    const serverApi = axios.create();
=======
    const serverApi = axios.create({
    });
>>>>>>> Stashed changes

    return {
        provide: {
            api: serverApi
        }
    }
})