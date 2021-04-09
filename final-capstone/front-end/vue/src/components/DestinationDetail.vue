<template>
    <div class="DestinationDetail" v-if="!isLoading">
        <h1>{{destination.name}}</h1>
        <h2>{{destination.description}}</h2>
        <div class="Hours" v-for="anHour in destination.hours" :key="anHour.hourId">
            <h3>{{anHour.dayOfWeek}}: 
                {{anHour.open}} -
                {{anHour.close}}  

           </h3>

        </div>
        <a :href="destination.website">{{destination.website}}</a>

        <img :src="destination.image" alt="Landmark Image" class="center">
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
    display: flex;
    color: black;
    justify-content: center;

}

h2 {
    display: flex;
    color: black;
    justify-content: center;
    margin: 20px;
    padding: 20px;
}

.Hours {
    display: flex;
    color: black;
    justify-content: center; 
    margin: -30px;
    
    
}

.center {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: auto;


}


a {
    display: flex;
    color: black;
    justify-content: center;
    margin: 30px;
}
 
 a:hover {
     color: red

 }

</style>