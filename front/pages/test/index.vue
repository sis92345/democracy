<script setup>

</script>
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
_vue.$api.post( "/api/find_mameber" );
//useFetch( "/api/find_mameber" );

</script>
<style scoped>
</style>