import { defineStore } from "pinia";
import axios from "axios";
import {Integer} from "~node_modules/type-fest";

export const useAuthStore = defineStore({
    id: "auth",
    state: () => ({
        user: JSON.parse(localStorage.getItem("user")),
        isLogin: null,
        reissue: false,
    }),
    getters: {},
    actions: {
        setUser(user:JSON) {
            this.user = user;
            localStorage.setItem("user", JSON.stringify(user));
            if (user != null) {
                this.isLogin = true;
            } else {
                this.isLogin = false;
            }
        },
        login(data:JSON, onSuccess:Function, onError:Function) {
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
        check(onSuccess:Function, onError:Function) {
            const data = {
                accessToken: this.user.accessToken,
                refreshToken: this.user.refreshToken,
            };
            axios
                .post("/api/auth/check", data)
                .then((res) => {
                    this.user.accessToken = res.data.result[0].accessToken;
                    this.user.refreshToken = res.data.result[0].refreshToken;
                    this.setUser(this.user);
                    onSuccess(res);
                })
                .catch((err) => {
                    this.isLogin = false;
                    if (onError != null) {
                        onError(err);
                    }
                });
        },
        async reissueToken() {
            const data = {
                refreshToken: this.user.refreshToken,
            };
            try {
                if (!this.reissue) {
                    this.reissue = true;
                    const rtn = await axios.post("/api/auth/reissue", data);
                    this.reissue = false;
                    this.user.accessToken = rtn.data.result[0].accessToken;
                    this.user.refreshToken = rtn.data.result[0].refreshToken;
                    this.setUser(this.user);
                } else {
                    let cnt = 0;
                    while (this.reissue && cnt < 10) {
                        await sleep(1000);
                        cnt++;
                    }
                }
                return true;
            } catch (err) {
                if (err.response.data != null) {
                    this.reissue = false;
                    this.setUser(null);
                }
                return false;
            }
        },
        join(data:JSON, onSuccess:Function, onError:Function) {
            axios
                .post("/api/auth/join", data)
                .then((res) => {
                    onSuccess(res);
                })
                .catch((err) => {
                    onError(err);
                });
        },
        logout(onSuccess:Function  ) {
            this.setUser(null);
            onSuccess();
            // location.href = "/";
        },
    },
});

function sleep(ms:number) {
    return new Promise((r) => setTimeout(r, ms));
}