import {defineStore} from "pinia";

export const authInfo = defineStore({
    id:'auth',
    state: () => ({
        // user: JSON.parse(localStorage.getItem("user")),
        isLogin: null,
        reissue: false,
    }),
    getters: {},
    actions:{}
})