<template>
<div>
  <table>
    <tr>
      <th>게시글 제목</th>
      <th>{{post.title}}</th>
    </tr>
    <tr>
      <td>게시글내용</td>
      <td>{{post.title}}</td>
    </tr>
    <tr>
      <td>작성자이름</td>
      <td>{{post.name}}</td>
    </tr>
    <tr>
      <td>작성일자</td>
      <td>{{post.created_time}}</td>
    </tr>
    <tr>
      <td><button @click="gotoPosts">목록으로</button></td>
      <td><button @click="logout">로그아웃</button></td>
      <td><button @click="updateRec">추천</button></td>
      <td><button @click="deletePost">삭제</button></td>
    </tr>
  </table>
</div>
</template>

<script>
import axios from 'axios'

export default {
  name: "PostDetailView",
  props:['id'],
  data() {
    return {
      post:'',
    }
  },
  computed:{

  },
  mounted() {
    axios.get("/api/posts/"+this.id,{params:{user_id:this.$store.state.user.userId}})
        .then((res)=>{
          console.log(res.data)
          this.post=res.data
        });


  },
  methods: {

    gotoPosts(){
      this.$router.push({name:'posts'})
    },
    logout(){
      this.$store.commit('user/updateUserId','')
      this.$router.push({name:'login'})

    },
    updateRec(){
      axios.put("/api/post/"+this.id)
          .then((res)=>{
            console.log(res.data)
            alert("추천되었습니다")
          });
    },
    deletePost(){
      axios.delete("/api/post/"+this.id)
      .then(()=>{
        alert("삭제되었습니다")
        this.$router.push({name:'posts'})

      })
      .catch(()=>{
        alert("삭제실패")
      })
    }
  }
}
</script>

<style scoped>

</style>