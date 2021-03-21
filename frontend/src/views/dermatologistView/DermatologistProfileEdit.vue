<template>
    <div id="dermatologistProfileEdit">
      <v-app>

    <v-row>
      <v-col md="3" class="ml-10 mt-15">
             <h1 class="ml-n primary--text">User profile</h1>
        <v-card  color="primary lighten-1" elevation="3" class="pa-6 primary">
          <p class="font-weight-medium">Name : {{ pharmacist.name }}</p>
          <p class="font-weight-medium">Lastname : {{ pharmacist.lastName }}</p>
          <p class="font-weight-medium">
            Phone number : {{ pharmacist.phoneNumber }}
          </p>
          <p class="font-weight-medium">Address : {{ pharmacist.location }}</p>
          <p class="font-weight-medium">City : {{ pharmacist.city }}</p>
          <p class="font-weight-medium">Country : {{ pharmacist.country }}</p>

          <v-dialog
            v-model="dialog"
            transition="dialog-bottom-transition"
            max-width="600"
          >
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                class="rounded-circle"
                fab
                dark
                large
                color="secondary"
                v-bind="attrs"
                v-on="on"
              >
                <v-icon dark> mdi-pencil </v-icon>
              </v-btn>
            </template>
            <template>
              <v-card>
                <v-card>
                  <v-toolbar flat color="primary" dark>
                    <v-toolbar-title>Edit</v-toolbar-title>
                  </v-toolbar>
                  <v-tabs vertical>
                    <v-tab>
                      <v-icon left> mdi-account </v-icon>
                      Personal info
                    </v-tab>
                    <v-tab>
                      <v-icon left> mdi-lock </v-icon>
                      Password
                    </v-tab>

                    <v-tab-item>
                      <v-card flat>
                        <v-text-field
                          v-model="pharmacist.name"
                          label="First Name"
                          filled
                        ></v-text-field>
                        <v-text-field
                          v-model="pharmacist.lastName"
                          label="Last name"
                          filled
                        ></v-text-field>
                        <v-text-field
                          v-model="pharmacist.phoneNumber"
                          label="Phone number"
                          filled
                        ></v-text-field>
                        <v-text-field
                          v-model="pharmacist.location"
                          label="Address"
                          filled
                        ></v-text-field>
                        <v-text-field
                          v-model="pharmacist.city"
                          label="City"
                          filled
                        ></v-text-field>
                        <v-text-field
                          v-model="pharmacist.country"
                          label="Country"
                          filled
                        ></v-text-field>
                        <v-btn
                          depressed
                          class="mr-4 mb-5"
                          @click="dialog = false"
                        >
                          Cancel
                        </v-btn>
                        <v-btn
                          depressed
                          class="mr-4 mb-5"
                          @click="changePersonalData"
                          color="primary"
                        >
                          Submit
                        </v-btn>
                      </v-card>
                    </v-tab-item>
                    <v-tab-item>
                      <v-container fluid>
                        <v-card elevation="4" class="pa-5">
                          <v-card-title>Change password</v-card-title>
                          <v-form>
                            <v-text-field
                              v-model="form.oldPassword"
                              :append-icon="
                                form.showOldPassword ? 'mdi-eye' : 'mdi-eye-off'
                              "
                              :errorMessages="oldPasswordErrors"
                              :type="form.showOldPassword ? 'text' : 'password'"
                              label="Current password"
                              @click:append="
                                form.showOldPassword = !form.showOldPassword
                              "
                              @blur="$v.form.oldPassword.$touch()"
                              @input="$v.form.oldPassword.$touch()"
                            ></v-text-field>

                            <v-text-field
                              v-model="form.newPassword"
                              :append-icon="
                                form.showNewPassword ? 'mdi-eye' : 'mdi-eye-off'
                              "
                              :errorMessages="newPasswordErrors"
                              :type="form.showNewPassword ? 'text' : 'password'"
                              label="New password"
                              @click:append="
                                form.showNewPassword = !form.showNewPassword
                              "
                              @blur="$v.form.newPassword.$touch()"
                              @input="$v.form.newPassword.$touch()"
                            ></v-text-field>

                            <v-text-field
                              v-model="form.repeatedNewPassword"
                              :append-icon="
                                form.showRepeatedNewPassword
                                  ? 'mdi-eye'
                                  : 'mdi-eye-off'
                              "
                              :errorMessages="repeatedNewPasswordErrors"
                              :type="
                                form.showRepeatedNewPassword
                                  ? 'text'
                                  : 'password'
                              "
                              label="Confirm new password"
                              @click:append="
                                form.showRepeatedNewPassword = !form.showRepeatedNewPassword
                              "
                              @blur="$v.form.repeatedNewPassword.$touch()"
                              @input="$v.form.repeatedNewPassword.$touch()"
                            ></v-text-field>

                            <v-card-actions class="pt-5">
                              <v-btn color="secondary" text @click="reset">
                                Reset form
                              </v-btn>
                              <v-spacer></v-spacer>
                              <v-btn color="primary" @click="submit">
                                Change password
                              </v-btn>
                            </v-card-actions>
                          </v-form>

                          <v-overlay
                            :absolute="true"
                            :value="loading"
                            :opacity="0.7"
                            color="#ffffff"
                          >
                            <v-progress-circular
                              indeterminate
                              color="secondary"
                            ></v-progress-circular>
                          </v-overlay>

                          <v-snackbar
                            v-model="snackbar"
                            :timeout="2000"
                            bottom
                            class="mb-5"
                            right
                          >
                            {{ snackbarText }}

                            <template v-slot:action="{ attrs }">
                              <v-btn
                                color="primary"
                                text
                                v-bind="attrs"
                                @click="snackbar = false"
                              >
                                Close
                              </v-btn>
                            </template>
                          </v-snackbar>
                        </v-card>
                      </v-container>
                    </v-tab-item>
                    <v-tab-item>
                      <v-card flat> </v-card>
                    </v-tab-item>
                  </v-tabs>
                </v-card>
              </v-card>
            </template>
          </v-dialog>
        </v-card>
      </v-col>
      <v-col md="6">

        <div class="calendar pa-8">
          <calendarDermatologist></calendarDermatologist>
        </div>
      </v-col>
    </v-row>
  </v-app>
    </div>

</template>


<script>
export default {
  name: "DermatologistProfileEdit",
  data() {
    return {
      show: false
    };
  },
};
</script>


<style>

</style>