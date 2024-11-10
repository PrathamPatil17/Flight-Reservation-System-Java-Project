import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-register',
  standalone: true,
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  imports: [FormsModule, CommonModule],
})
export class RegisterComponent {
  name: string = '';
  surname: string = '';
  email: string = '';
  password: string = '';

  registerUser() {
    let users = JSON.parse(localStorage.getItem('users') || '[]');

    const existingUser = users.find((user: any) => user.email === this.email);
    if (existingUser) {
      alert('User with this email already exists.');
      return;
    }

    users.push({ name: this.name, surname: this.surname, email: this.email, password: this.password });
    localStorage.setItem('users', JSON.stringify(users));

    alert('Registration successful!');
    this.clearFields();
  }

  clearFields() {
    this.name = '';
    this.surname = '';
    this.email = '';
    this.password = '';
  }
}
