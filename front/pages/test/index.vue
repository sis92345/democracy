<script setup>
import { useFetch, useNuxtApp } from "nuxt/app";
	
	const version = 2 + 1;
	const _vue = useNuxtApp();
	_vue.$api.post( "/api/find_mameber" );
	//useFetch( "/api/find_mameber" );
</script>
<template>
	<div>
		<el-button>Default</el-button>
		<span v-text="version"></span>
	</div>
</template>

<style scoped>
</style>