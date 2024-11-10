import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-profile',
  standalone: true,
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
  imports: [CommonModule],
})
export class ProfileComponent implements OnInit {
  user: any;

  constructor(private router: Router) {}

  ngOnInit() {
    // Retrieve logged-in user from local storage
    const loggedInUser = localStorage.getItem('loggedInUser');
    if (loggedInUser) {
      this.user = JSON.parse(loggedInUser); // Parse user data
      console.log("LoggedIn User:", this.user); // Debug log
    } else {
      // Redirect to login if no user is found
      this.router.navigate(['/login']);
    }
  }

  logout() {
    // Clear the logged-in user
    localStorage.removeItem('loggedInUser');
    // Optionally, you can clear the user property as well
    this.user = null; 
    // Reload the page
    window.location.reload(); // This will refresh the page
  }
}
