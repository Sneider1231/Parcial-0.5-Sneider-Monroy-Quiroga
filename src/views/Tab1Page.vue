<template>
  <ion-page>
    <ion-header>
      <ion-toolbar color="primary">
        <ion-title>{{ hotel.name }}</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true" class="ion-padding">
      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">{{ hotel.name }}</ion-title>
        </ion-toolbar>
      </ion-header>

      <!-- Contenido principal -->
      <ion-card>
        <ion-card-header>
          <ion-card-title>{{ hotel.name }}</ion-card-title>
        </ion-card-header>

        <ion-card-content>
          <p class="hotel-location">{{ hotel.location }}</p>
          <p>{{ hotel.description }}</p>
          <p><strong>Comodidades:</strong></p>
          <ion-list lines="none">
            <ion-item v-for="amenity in hotel.amenities" :key="amenity">
              <ion-icon slot="start" name="checkmark-circle-outline"></ion-icon>
              <ion-label>{{ amenity }}</ion-label>
            </ion-item>
          </ion-list>
        </ion-card-content>
      </ion-card>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonCard, IonCardHeader, IonCardTitle, IonCardContent, IonList, IonItem, IonIcon, IonLabel } from '@ionic/vue';

const hotel = {
  name: 'Hotel Estrella de Mar',
  location: 'Playa Paraíso, Santa Marta, Colombia',
  description: `Bienvenido al Hotel Estrella de Mar, un oasis de lujo y confort en la espectacular Santa Marta. Situado en la idílica Playa Paraíso, nuestro hotel ofrece una experiencia única donde la elegancia se combina con la serenidad del mar Mediterráneo.

Nuestro hotel cuenta con habitaciones exquisitamente decoradas que ofrecen vistas panorámicas al océano y a los jardines tropicales circundantes. Disfruta de la comodidad de nuestras instalaciones de primera clase, que incluyen una piscina infinity de aguas cristalinas, un lujoso spa con una amplia gama de tratamientos revitalizantes, y un gimnasio completamente equipado para mantener tu rutina de ejercicios incluso durante las vacaciones.

Además, deleita tu paladar con una experiencia gastronómica excepcional en nuestros exclusivos restaurantes, donde nuestros chefs expertos fusionan la cocina mediterránea con sabores internacionales para crear platos exquisitos que satisfacen los gustos más exigentes.

Ya sea que estés buscando relajarte bajo el sol en nuestra playa privada, explorar los encantadores pueblos costeros cercanos o disfrutar de la animada vida nocturna de la zona, el Hotel Estrella de Mar te brinda el refugio perfecto para unas vacaciones inolvidables.

¡Descubre el auténtico lujo y la hospitalidad excepcional en el Hotel Estrella de Mar, donde cada momento se convierte en una experiencia inolvidable!`,
  amenities: ['Piscina', 'Spa', 'Gimnasio', 'Restaurante gourmet', 'Playa privada', 'Wifi gratuito', 'Estacionamiento']
};
</script>

<style scoped>
.hotel-background {
  background-image: url('/public/estelar-playa-manzanillo.jpg');
  background-size: cover;
  background-position: center;
  color: rgb(133, 128, 128); /* Ajusta el color del texto según la imagen de fondo */
}

.hotel-location {
  font-style: italic;
  color: #ddd;
}
</style>
