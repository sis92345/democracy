import {defineStore} from "pinia";
import axios from "axios";

export const authInfo = defineStore({
    id:'auth',
    state: () => ({
        user: JSON.parse(localStorage.getItem("user")),
        isLogin: null,
        reissue: false,
    }),
    getters: {},
    actions:{
        setUser(user) {
            this.user = user;
            localStorage.setItem("user", JSON.stringify(user));
            if (user != null) {
                this.isLogin = true;
            } else {
                this.isLogin = false;
            }
        },
        login(data, onSuccess, onError) {
            axios
                .post("/api/auth/login", data)
                .then((res) => {
                    if (res.data.result.length > 0) {
                        const user = res.data.result[0];
                        this.setUser(user);
                        onSuccess(res);
                    }
                })
                .catch((err) => {
                    onError(err);
                });
        },
    }
})