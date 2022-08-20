<template>
  <div  class="login_main_container">
    <div class="login_box">
      <img class="logo" src="@/assets/image/logo/democracy3.png"  alt="logo"/>
      <div class="login_box_id_pw">
        <div class="inner-contents mtb-05">
          <el-input v-model="id"
                    le
                    prefix-icon="el-icon-user"
                    placeholder="아이디"/>
        </div>
        <div class="inner-contents mtb-05">
          <el-input v-model="pw"
                    prefix-icon="el-icon-lock"
                    placeholder="비밀번호"
                    show-password/>
        </div>
        <div class="mtb-2">
          <el-button type="primary" @click="()=>{ useRouter().push( '/main' ); }">로그인</el-button>
          <el-button type="info">회원가입</el-button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name : "login_main",
  data(){
    return {
      id : "",
      pw : "",
    }
  }
}
</script>
<style scoped>
</style>
