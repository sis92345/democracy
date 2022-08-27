<script setup>
const MyButton = resolveComponent( "list/memberList" )
console.log( MyButton )
const boolean = ref(true)
</script>

<template>
	<!-- layout-container-demo -->
	<el-container class="main_container">
		<el-aside class="list_container">
		
			<div class="list_container__title m-box-1">
				<span>Member</span>
			</div>
			<el-divider border-style="dashed" />
			<component :is="boolean ? MyButton : 'div'" />
		</el-aside>
		
		<el-container>
			<el-header class="header-container">
				<div class="header-container__left-area ml-1">
					<span>체팅 해더</span>
				</div>
				
				<div class="header-container__right-area">
					<span>기타 선택 창</span>
				</div>
			</el-header>
			
			<el-main class="main_container">
				<div>
					<img class="logo" src="@/assets/image/logo/democracy3.png"  alt="logo"/>
				</div>
			</el-main>
		</el-container>
	</el-container>
</template>
