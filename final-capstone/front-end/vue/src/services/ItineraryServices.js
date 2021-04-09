import axios from 'axios';
export default {

createItinerary() {
    return axios.post(`/createItinerary`); // send their starting point, date, landmarks, route
},

submitItinerary() { // finalize itinerary and generate route

},

getItineraryById(userId) {
    return axios.get(`/itineraryUser/${userId}`);
},

deleteItinerary(itineraryId) {
    return axios.delete(`/deleteItinerary/${itineraryId}`)
},

addToItinerary(destinationId, itineraryId) {
    return axios.post(`/addItinerary/${destinationId}/${itineraryId}`)
},
}