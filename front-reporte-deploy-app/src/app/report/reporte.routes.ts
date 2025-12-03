import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path:'',
        redirectTo:'dashboard',
        pathMatch:'full'
    },
    {
        path: 'dashboard',
        loadComponent: () => import('./feature/dashboard/dashboard').then(m => m.Dashboard)
    },
    {
        path: 'detalle',
        loadComponent: () => import('./feature/detalle-deploy/detalle-deploy').then(m => m.DetalleDeploy)
    }
];
