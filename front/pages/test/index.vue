<template>
	<div>
		<el-button>Default</el-button>
		<el-icon></el-icon>
    {{auth.reissue}}
	</div>
</template>
<script setup>
import { useNuxtApp } from "nuxt/app";

const version = 2 + 1;
const _vue = useNuxtApp();
_vue.$api.post( "/api/find_mameber" )
    .then(response=>{
      console.log(response.data[0]);
    });
//useFetch( "/api/find_mameber" );

</script>
<style scoped>
</style>