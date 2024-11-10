import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';  
import { RouterOutlet } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ProfileComponent } from './profile/profile.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule, 
    RouterOutlet,
    LoginComponent,
    RegisterComponent,
    ProfileComponent
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isUserLoggedIn: boolean = false; // Track user login status
  isLoginFormVisible: boolean = true;
  isRegistrationFormVisible: boolean = false;

  // Method to set user login status
  setUserLoginStatus(status: boolean) {
    this.isUserLoggedIn = status;
  }

  // Method to show login form
  showLoginForm() {
    this.isLoginFormVisible = true;
    this.isRegistrationFormVisible = false;
  }

  // Method to show registration form
  showRegistrationForm() {
    this.isLoginFormVisible = false;
    this.isRegistrationFormVisible = true;
  }

  // Method to handle successful login
  onLoginSuccess() {
    this.isUserLoggedIn = true; // Update login status
    this.isLoginFormVisible = false; // Hide login form
    this.isRegistrationFormVisible = false; // Hide registration form
  }
}
