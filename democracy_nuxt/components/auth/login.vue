<script lang="ts">
import { ref } from 'vue'

export default {
	setup () {
		return {
			text: ref('')
		}
	}
}
</script>
<template>
	<div class="login_main_container">
		<div class="login_box">
			<img class="logo" src="@/assets/image/logo/democracy3.png"  alt="logo"/>
			<div class="login_box_id_pw">
				<div class="inner-contents mtb-05">
					<q-input rounded filled v-model="text" placeholder="아이디" />
				</div>
				<div class="inner-contents mtb-05">
					<q-input rounded filled v-model="text" placeholder="비밀번호" />
				</div>
				<div class="mtb-2 width-max">
					<q-btn class="width-max glossy" rounded color="teal">
						<q-icon left size="3em" name="login" />
						<div>로그인</div>
					</q-btn>
				</div>
			</div>
		</div>
	</div>
</template>