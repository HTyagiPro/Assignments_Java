import { NgModule } from "@angular/core";
import { TrainService } from "./train.service";
import { TrainListComponent } from "./train-list-component";
import { CommonModule } from "@angular/common";
import { HttpClientModule } from "@angular/common/http";

@NgModule({
    declarations:[TrainListComponent],
    imports:[HttpClientModule, CommonModule],
    exports:[TrainListComponent],
    providers:[TrainService]

})
export class TrainModule{

}