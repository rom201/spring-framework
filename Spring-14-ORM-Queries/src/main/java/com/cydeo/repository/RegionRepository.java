package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {

    //show all regions in Canady  same as select * from reqions where country like Canada
    List<Region> findByCountry(String country);

    //display al regions in Canada without duplicates

    List<Region> findDistinctByCountry(String country);

    ///Display all regions with country name includes 'United'

    List<Region> findByCountryContaining(String United);

    //Display all regions with country name includes 'United' in order

    List<Region> findByCountryContainingOrderByCountry(String country);
    List<Region> findByCountryContainingOrderByRegionDesc(String country);

    //Display top 2 regions in Canada


    List<Region> findTop2ByCountry(String country);
}
