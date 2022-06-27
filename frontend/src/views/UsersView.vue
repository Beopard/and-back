<template>
<div>
  <table>
    <tr>
      <th>회원번호</th>
      <th>회원이름</th>
      <th>전문가유무</th>
    </tr>
    <tr v-for="(user,i) in users" :key="i">
      <td>{{i+1}}</td>
      <td>{{user.name}}</td>
      <td v-if="user.role=='전문가'">true</td>
      <td v-else>false</td>
    </tr>
  </table>
  <button @click="goToMain">메인으로돌아가기</button>
</div>
</template>

<script>
import axios from 'axios'

export default {
  name: "UsersView",
  data() {
    return {
      users:'',
    }
  },
  computed:{

  },
  mounted() {
    axios.get("/api/users")
        .then((res)=>{
          console.log(res.data)
          this.users=res.data

        });


  },
  methods: {
    goToMain(){
      this.$router.push({name:'main'})
    }
  }
}
</script>

<style scoped>

</style>