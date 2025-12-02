import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: 'dashboard',
        loadComponent: () => import('./dashboard/dashboard').then(m => m.Dashboard)
    },
    {
        path: 'detalle',
        loadComponent: () => import('./detalle-deploy/detalle-deploy').then(m => m.DetalleDeploy)
    }
];
