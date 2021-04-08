<template>
    <div class="DestinationDetail" v-if="!isLoading">
        <h1>{{destination.name}}</h1>
        <h2>{{destination.description}}</h2>
        <div v-for="anHour in destination.hours" :key="anHour.hourId">
            <h3>{{anHour.dayOfWeek}}: 
                {{anHour.open}} -
                {{anHour.close}}  

           </h3>

        </div>
        <a :href="destination.website">{{destination.website}}</a>

        <img :src="destination.image" alt="Landmark Image">
    </div>
</template>

<script>
import DestinationServices from '../services/DestinationServices'

export default {
    created() {
        DestinationServices.getADestination(this.$route.params.id).then(response => {
            this.destination = response.data[0]
            console.log(this.destination)

         DestinationServices.getDestinationHours(this.$route.params.id).then(res => {
             this.destination.hours = res.data
             this.isLoading = false;
             console.log(this.destination)

         })   


        });
    },
    data() {
        return {
            destination: {},
            isLoading: true
        }

        
    }
}

</script>

<style scoped>
h1 {
color: black;
}

a {
    color: black;
    
}
 
 a:hover {
     color: red

 }

</style>