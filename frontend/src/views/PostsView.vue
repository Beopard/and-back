<template>
<div>
  {{$store.state.user.userId}}님
  <button @click="gotoWrite">작성하기</button>
  <table>
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>글쓴이이름</th>
      <th>작성일자</th>
      <th>일반조회수</th>
      <th>전문가조회수</th>
      <th>추천수</th>
    </tr>
    <tr v-for="(post,i) in posts" :key="i" @click="goToDetail(post)">
      <td>{{post.post_id}}</td>
      <td>{{post.title}}</td>
      <td>{{post.name}}</td>
      <td>{{post.created_time}}</td>
      <td>{{post.views}}</td>
      <td>{{post.pro_views}}</td>
      <td>{{post.recommends}}</td>
    </tr>
  </table>
  <button @click="goToMain">메인으로돌아가기</button>

</div>
</template>

<script>
import axios from 'axios'

export default {
  name: "PostView",
  data() {
    return {
      posts:'',
    }
  },
  computed:{

  },
  mounted() {
    axios.get("/api/posts")
        .then((res)=>{
          this.posts=res.data
          console.log(res.data)
        });



  },
  methods: {
    goToDetail(post){
      console.log(post)
      this.$router.push({name:'postsDetail',params:{id:post.post_id}})
    },
    gotoWrite(){
      this.$router.push({name:'add'})
    },
    goToMain(){
      this.$router.push({name:'main'})
    }
  }
}
</script>

<style scoped>

</style>