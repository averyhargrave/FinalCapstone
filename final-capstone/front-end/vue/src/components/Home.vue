<template> <!-- HTML goes here -->
    <div>
        <h1>Explore Cleveland</h1>
        <div class="destinations">
            <div class="status-message error" v-show="errorMsg != ''">{{errorMsg}}</div>
            <div class="loading" v-if="isLoading">
                <!-- We can put an image here later -->
            </div>
        <div> <!-- We need to figure out how to do a search box up here -->
            <form v-if="!isSubmitted" v-on:submit.prevent="filterDestinations">
                <input v-model="searchTerm">  <!-- two-way binds to searchTerm, attach to API request -->
                 <button>Submit</button>    <!-- might need to add something here -->
            </form>
            <div v-else>
                <!-- Loop through destinations array and display names after search -->
                <ul>
                    <li v-for="destination in destinations" v-bind:key="destination.destination_id">
                        <router-link :to="{ name: 'DestinationDetail', params: { id: destination.destination_id}}">
                            {{ destination.name }}
                        </router-link>
                    </li>
                </ul>
            </div>
            <router-link :to="{ name: 'register' }">Create an account</router-link>
    </div>
        </div>
        </div>
</template>

<script> // Vue goes here
import DestinationService from '../services/DestinationServices';

export default {
    data() {
        return {
            destinations: [],
            errorMsg: '',
            searchTerm: '',
            isSubmitted: false,
            isLoading: false
        }
    },
    created() {

    },
    methods: {
        // Create method that takes the service method and sets response.data to this.destinations
        filterDestinations() {
            // Use services to get destinations that match the searchTerm
            DestinationService.getDestinations().then(response => {
                this.destinations = response.data
                this.destinations.filter(destination => destination.name == this.searchTerm).filter(destination => destination.type == this.searchTerm) // Chain more filters here (OR statements in SQL)
                this.isSubmitted = true;
            })
        }
    }
}
</script>

<style scoped>  /* CSS goes here */
</style>