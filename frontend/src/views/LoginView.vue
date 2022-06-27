<template>
<div>
  LoginView
  <div>id<input v-model="user_id" type="text"></div>
  <div>password<input v-model="password" type="password"></div>
  <button @click="login">login</button>
</div>
</template>

<script>
import axios from 'axios'

export default {
  name: "LoginView",
  data() {
    return {
      user_id:'',
      password:'',
    }
  },
  computed:{

  },
  mounted() {

  },
  methods: {
    login(){
      console.log(this.user_id)
      console.log(this.password)

      axios.get("/api/login",{params:{user_id:this.user_id,password:this.password}})
          .then((res)=>{
            console.log(res.data)
            if(res.data==''){
              alert("실패!없는회원이거나 비밀번호가 틀렸습니다")
            }else{
              alert("성공")
              this.$store.commit('user/updateUserId',res.data)
              this.$router.push({name:'main'})

            }
          });

    }
  }
}
</script>

<style scoped>

</style>