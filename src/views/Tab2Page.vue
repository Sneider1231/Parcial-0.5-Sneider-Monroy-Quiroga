<template>
  <ion-page>
    <ion-header>
      <ion-toolbar color="primary">
        <ion-title>Registro de Datos</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true" class="ion-padding">
      <ion-grid>
        <ion-row>
          <ion-col size="12" size-md="6" offset-md="3">
            <ion-card>
              <ion-card-content>
                <ion-item>
                  <ion-label position="stacked">Nombre</ion-label>
                  <ion-input v-model="formData.name" placeholder="Nombre completo" @input="validateName"></ion-input>
                </ion-item>
                <ion-item>
                  <ion-label position="stacked">Número de Teléfono</ion-label>
                  <ion-input v-model="formData.phoneNumber" type="tel" placeholder="Número de teléfono" @input="validatePhoneNumber"></ion-input>
                </ion-item>
                <ion-item>
                  <ion-label position="stacked">Fecha de Entrada</ion-label>
                  <ion-datetime v-model="formData.checkInDate" display-format="D MMM YYYY" placeholder="Seleccionar fecha"></ion-datetime>
                </ion-item>
                <ion-item>
                  <ion-label position="stacked">Fecha de Salida</ion-label>
                  <ion-datetime v-model="formData.checkOutDate" display-format="D MMM YYYY" placeholder="Seleccionar fecha"></ion-datetime>
                </ion-item>
              </ion-card-content>
            </ion-card>
            <ion-button expand="block" @click="submitForm()">Enviar</ion-button>
            <ion-toast :isOpen="showToast" message="Tus datos fueron registrados correctamente" duration="3000" onIonDidDismiss="showToast = false"></ion-toast>
          </ion-col>
        </ion-row>
      </ion-grid>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonGrid, IonRow, IonCol, IonCard, IonCardContent, IonItem, IonLabel, IonInput, IonDatetime, IonButton, IonToast } from '@ionic/vue';
import { ref } from 'vue';

const formData = {
  name: '',
  phoneNumber: '',
  checkInDate: '',
  checkOutDate: ''
};

const showToast = ref(false);

const validateName = (event: any) => {
  const inputValue: string = event.target.value;
  // Expresión regular que solo permite letras y espacios
  const regex = /^[a-zA-Z\s]*$/;
  if (!regex.test(inputValue)) {
    // Si el valor no coincide con la expresión regular, eliminamos el último carácter ingresado
    formData.name = inputValue.slice(0, -1);
  }
};

const validatePhoneNumber = (event: any) => {
  const inputValue: string = event.target.value;
  // Expresión regular que solo permite números
  const regex = /^[0-9]*$/;
  if (!regex.test(inputValue)) {
    // Si el valor no coincide con la expresión regular, eliminamos el último carácter ingresado
    formData.phoneNumber = inputValue.slice(0, -1);
  }
};

const submitForm = () => {
  // Aquí puedes enviar los datos a través de una solicitud HTTP o realizar cualquier otra acción necesaria
  console.log(formData);
  // Mostrar la notificación
  showToast.value = true;
};
</script>

<style scoped>
ion-card {
  margin-top: 20px;
}
</style>


