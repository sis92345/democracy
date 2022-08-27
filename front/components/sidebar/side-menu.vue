<template>
	<el-row>
		<el-col>
			<el-menu
				default-active="2"
				@select="select"
				background-color="lightgrey"
			>
				<el-menu-item index="list/memberList">
					<el-icon><User /></el-icon>
					<span>친구 목록</span>
				</el-menu-item>
				<el-menu-item index="2">
					<el-icon><ChatLineSquare /></el-icon>
					<span>채팅</span>
				</el-menu-item>
				<el-menu-item index="3">
					<el-icon><InfoFilled /></el-icon>
					<span>내 정보</span>
				</el-menu-item>
			</el-menu>
		</el-col>
	</el-row>
</template>

<script lang="ts" setup>

const emit = defineEmits(["clickMenu"])

const select = ( key : string , indexPath : string[]) => {
	emit( "clickMenu" , key );
}
</script>