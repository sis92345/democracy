<template>
  <div  class="login_main_container">
    <div class="login_box">
      <img class="logo" src="@/assets/image/logo/democracy3.png"  alt="logo"/>
      <div class="login_box_id_pw">
        <div class="inner-contents mtb-05">
          <el-input v-model="state.id"
                    le
                    prefix-icon="el-icon-user"
                    placeholder="아이디"/>
        </div>
        <div class="inner-contents mtb-05">
          <el-input v-model="state.password"
                    prefix-icon="el-icon-lock"
                    placeholder="비밀번호"
                    show-password/>
        </div>
        <div class="mtb-2">
          <el-button type="primary" @click="login()">로그인</el-button>
          <el-button type="info">회원가입</el-button>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup>
import {authInfo} from "../../store/auth";
import { reactive } from "vue";

const state = reactive({
  id: "",
  password: "",
  username: "",
});

const $router = useRouter();
const auth = authInfo();


const login =() => {
  const data = {
    id : state.id,
    password : state.password
  }  

  auth.login(
    data,
    () => {
        $router.replace("/main");
    },
    (err) => {
      if (err.response != null) {
        alert("실패");
      }
    }
  );
}
</script>
<style scoped>
</style>
