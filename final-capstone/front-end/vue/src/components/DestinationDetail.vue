<template>
    <div>
        
    </div>
</template>

<script>
import DestinationServices from '../services/DestinationServices'

export default {
    created() {
        DestinationServices.getADestination(this.$route.params.id).then(response => {
            this.destination = response.data
        });
    },
    data() {
        return {
            destination: {}
        }

        
    }
}

</script>

<style scoped>
</style>