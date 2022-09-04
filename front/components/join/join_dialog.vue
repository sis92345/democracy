<script lang="ts" setup>
    import { reactive } from 'vue'

    const props = defineProps({
      dialogFormVisible:String
    })

    const emit = defineEmits(["closePopUp"]);

    const closePopUp = () => {
      emit("closePopUp");
    }
    
    const formLabelWidth = '140px'
    
    const form = reactive({
      id:'',
      pw:'',
      name:'',
      phone:'',
    })

    const pwOk = ref(null);
</script>
<template>
     <el-dialog v-model="props.dialogFormVisible" title="Shipping address">
    <el-form :model="form">
      <el-form-item label="아이디" :label-width="formLabelWidth">
        <el-input v-model="form.id" autocomplete="off" />
      </el-form-item>
      <el-form-item label="비밀번호" :label-width="formLabelWidth">
        <el-input v-model="form.pw" autocomplete="off" type="password"></el-input>
      </el-form-item>
      <el-form-item label="비밀번호 확인" :label-width="formLabelWidth">
        <el-input v-model="pwOk" autocomplete="off" type="password"></el-input>
      </el-form-item>
      <el-form-item label="이름" :label-width="formLabelWidth">
        <el-input v-model="form.name" autocomplete="off" type="password"></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="closePopUp()" type="danger">Cancel</el-button>
        <el-button type="primary">회원가입</el-button>
      </span>
    </template>
  </el-dialog>
</template>
<style scoped>
  .el-button--text {
    margin-right: 15px;
  }
  .el-select {
    width: 300px;
  }
  .el-input {
    width: 300px;
  }
  .dialog-footer button:first-child {
    margin-right: 10px;
  }
  </style>