import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddScheduledflightComponent } from './add-scheduledflight/add-scheduledflight.component';
import {FormsModule} from '@angular/forms';
import { ScheduledFlightService } from './services/scheduledflightservice';
import { ModifyScheduledflightComponent } from './modify-scheduledflight/modify-scheduledflight.component';
import { ListScheduledflightComponent } from './list-scheduledflight/list-scheduledflight.component';
import { SearchScheduledflightComponent } from './search-scheduledflight/search-scheduledflight.component';

@NgModule({
  declarations: [
    AppComponent,
    AddScheduledflightComponent,
    ModifyScheduledflightComponent,
    ListScheduledflightComponent,
    SearchScheduledflightComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule

  ],
  providers: [ScheduledFlightService],
  bootstrap: [AppComponent]
})
export class AppModule { }
