<template>
	<div>
		<el-button>Default</el-button>
		<el-icon></el-icon>
    {{auth.reissue}}
	</div>
</template>
<script setup>

import {authInfo} from "../../store/auth";

const auth = authInfo();



</script>
<style scoped>
</style>