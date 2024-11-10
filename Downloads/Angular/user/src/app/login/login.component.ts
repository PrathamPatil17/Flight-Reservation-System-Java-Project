import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  imports: [FormsModule, CommonModule],
})
export class LoginComponent {
  email: string = '';
  password: string = '';

  @Output() loginSuccess = new EventEmitter<void>(); // Emit event on successful login

  constructor(private router: Router) {}

  loginUser() {
    let users = JSON.parse(localStorage.getItem('users') || '[]');
    const user = users.find((u: any) => u.email === this.email && u.password === this.password);

    if (user) {
      localStorage.setItem('loggedInUser', JSON.stringify(user));
      alert('Login successful!');
      this.loginSuccess.emit(); // Emit event to indicate successful login
      this.router.navigate(['/profile']); // Navigate to profile route
    } else {
      alert('Invalid email or password.');
    }
  }
}
