<template>
<div>
  <div>작성페이지 {{ $store.state.user.userId }}</div>
  title<input type="text" v-model="title">
  contents<input type="text" v-model="contents">
  <div><button @click="add">작성하기</button></div>
  <div><button @click="gotoPosts">목록으로</button></div>
</div>
</template>

<script>
import axios from 'axios'

export default {
  name: "PostAddView",
  data() {
    return {
      title:'',
      contents:'',
    }
  },
  computed:{

  },
  mounted() {
    // axios.get("/api/posts")
    //     .then((res)=>{
    //       this.exchangeRate=res.data
    //       console.log(res.data)
    //     });


  },
  methods: {
    add(){
      axios.post("/api/post","",{params:{title:this.title,contents:this.contents,user_id:this.$store.state.user.userId}})
          .then((res)=>{
            console.log(res.data)
            alert("성공")
          }).catch(()=>{
            alert("실패")
      });

    },
    gotoPosts(){
      this.$router.push({name:'posts'})
    },

  }
}
</script>

<style scoped>

</style>