<template>
  <div  class="login_main_container">
    <div class="login_box">
      <img src="@/assets/image/logo/democracy.png"  alt="logo"/>
      <div class="login_box_id_pw">
        <div class="inner-contents">
          <el-input v-model="id"
                    prefix-icon="el-icon-user"
                    placeholder="아이디"/>
        </div>
        <div class="inner-contents">
          <el-input v-model="pw"
                    prefix-icon="el-icon-lock"
                    placeholder="비밀번호"
                    show-password/>
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
