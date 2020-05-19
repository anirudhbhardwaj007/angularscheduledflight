import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddScheduledflightComponent } from './add-scheduledflight/add-scheduledflight.component';
import { ListScheduledflightComponent } from './list-scheduledflight/list-scheduledflight.component';
import { SearchScheduledflightComponent } from './search-scheduledflight/search-scheduledflight.component';
import { ModifyScheduledflightComponent } from './modify-scheduledflight/modify-scheduledflight.component';


const routes: Routes = [{
  path:'add-scheduledflight',
  component: AddScheduledflightComponent
}
,
{
  path:'list-scheduledflight',
  component:ListScheduledflightComponent
}
,
{
  path:'search-scheduledflight-schedule',
  component:SearchScheduledflightComponent
}
,
{
  path:'modify-scheduledflight',
  component:ModifyScheduledflightComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
