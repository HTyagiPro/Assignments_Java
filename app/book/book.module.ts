import { NgModule } from '@angular/core';
import { BookListComponent } from './book-list.component';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@NgModule({
    declarations: [BookListComponent],
    providers: [],
    bootstrap: [],
    imports: [FormsModule, CommonModule ],
    exports:[BookListComponent]
})
export class BookModule { }
