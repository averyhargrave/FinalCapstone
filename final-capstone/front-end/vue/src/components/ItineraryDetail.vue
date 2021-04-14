<template>
    <div class="ItineraryDetail">
        <h1>Itinerary of {{itinerary.date}}</h1>
        <button v-on:click="itineraryCreated = !itineraryCreated">Edit</button>
        <form v-if="itineraryCreated" v-on:submit.prevent="editItinerary">
            <label for="startingPoint">Starting point:</label><br>
            <input type="text" id="startingPoint" name="startingPoint" v-model="itinerary.startingPoint"><br>
            <label for="date">Date:</label><br>
            <input type="text" id="date" name="date" v-model="itinerary.date"><br>
            <button type="submit">Edit Itinerary</button>
        </form>
        <button v-on:click="deleteItinerary">Delete</button>
        <!-- Loop through destinations array and display names after search -->
        <ul>        
            <li v-for="destination in destinations" v-bind:key="destination.destinationId">
                <button v-on:click="removeFromItinerary(destination)">Remove From Itinerary</button>
                <router-link :to="{ name: 'DestinationDetail', params: { id: destination.destinationId}}" class="destinationDetail">
                    {{ destination.name }}
                </router-link>
            </li>
        </ul>
       <GoogleMap :destinations="destinations"/>
    </div>
</template>

<script>
import ItineraryServices from '../services/ItineraryServices.js'
import GoogleMap from '../components/GoogleMap.vue'

export default {
    components: {
    GoogleMap
  },
    name: 'Home',
    created() {
        ItineraryServices.getItineraryByItineraryId(this.$route.params.id).then(response => {
            this.itinerary = response.data;
        });
        ItineraryServices.viewDestinationsByItineraryId(this.$route.params.id).then(response => {
            this.destinations = response.data;
        });
    },
    data() {
        return {
            itinerary: [],
            destinations: [],
            itineraryCreated: false
        }
    },
    methods: {
        deleteItinerary() {

            ItineraryServices.deleteItinerary(this.itinerary.itineraryId).then(() => {
                this.$router.push('/')
            })
        },
        editItinerary() {
            ItineraryServices.editItinerary(this.itinerary.startingPoint, this.itinerary.date, this.itinerary.itineraryId)
        },
        changeCreated() {
             if (this.itineraryCreated === true) {
                this.itineraryCreated = false;
            } else {
            this.itineraryCreated = true;
            }
        },
        removeFromItinerary(destination) {
            const index = this.destinations.indexOf(destination);
            this.destinations.splice(index, 1);
            ItineraryServices.deleteDestinationFromItinerary(destination.destinationId);
        }
    }
}
</script>

<style scoped>

.ItineraryDetail {
    background-color: black;
}

</style>
