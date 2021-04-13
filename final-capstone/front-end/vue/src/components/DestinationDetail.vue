<template>
    <div class="DestinationDetail" v-if="!isLoading">
        <h1>{{destination.name}}</h1>
        <!-- drop-down up here that lists through user itineraries -->
        <button>Add to Itinerary</button>
    
        <select name="SelectItinerary" id="Select Itinerary" v-for="itinerary in itineraries" v-bind:key="itinerary.itineraryId">
            <option value="">Select Itinerary</option>

        </select>
        <!-- pushes you to itineraryDetail -->
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
import ItineraryServices from '../services/ItineraryServices'

export default {
    created() {
        DestinationServices.getADestination(this.$route.params.id).then(response => {
            this.destination = response.data[0]
            console.log(this.destination)

            DestinationServices.getDestinationHours(this.$route.params.id).then(res => {
                this.destination.hours = res.data
                this.isLoading = false;
                console.log(this.destination)
        
                ItineraryServices.getItineraryById(this.$store.state.user.id).then(response => {
                    this.itineraries = response.data;
                })
            })   
        });
    },
    data() {
        return {
            destination: {},
            isLoading: true,
            itineraries: []
        }

        
    },


}


</script>

<style scoped>
h1 {
    display: flex;
    color: black;
    justify-content: center;

}

button {
    display: flex;
    justify-content: center;
    margin: auto;
}

select {
    display: flex;
    justify-content: center;
    margin: auto;
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