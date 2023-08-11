import { Component } from '@angular/core';

@Component({
  selector: 'app-book-list',
  templateUrl: './book.component.html',
  styleUrls: []
})
export class BookListComponent {
  books = [
    {"bookTitle":"Java Ref.", "author":"Herbert","publication": "MC Grew", "price":550},
    {"bookTitle":"LetUsC.", "author":"Henry","publication": "Ratna Sagar", "price":950},
    {"bookTitle":"How TO C++.", "author":"Sumita Arora","publication": "MC Grew", "price":850},
    {"bookTitle":"Sherlok Holmes", "author":"Jk Smith","publication": "Ratna sagar", "price":650},
          ];

}
